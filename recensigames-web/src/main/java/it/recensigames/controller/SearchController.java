package it.recensigames.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.recensigames.dao.ConsoleDao;
import it.recensigames.dao.GiocoDao;
import it.recensigames.dto.GameSearchDTO;
import it.recensigames.model.Console;
import it.recensigames.model.Gioco;

@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private ApplicationContext context;
	@Autowired
	GiocoDao giocoDao;
	@Autowired
	ConsoleDao consoleDao;
	private Logger logger = Logger.getLogger(SearchController.class);
	
	@Transactional
	@RequestMapping(value = "/getGamesByTitle", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<GameSearchDTO> getGamesByTitle(@RequestParam(value = "titoloGioco") String titoloGioco) {
		logger.info("Starting service getGamesByTitle");
		List<GameSearchDTO> result = new ArrayList<GameSearchDTO>();
		if (!titoloGioco.equals("") && !titoloGioco.isEmpty()) {
			GameSearchDTO response;
			List<Gioco> listaGiochi = giocoDao.getAllGames();
			for (Gioco g : listaGiochi) {
				if(StringUtils.containsIgnoreCase(g.getTitoloGioco(), titoloGioco)){
					response = new GameSearchDTO();
					response.setTitolo(g.getTitoloGioco());
					response.setConsole(g.getListaConsoles().get(0).getNomeConsole());
					result.add(response);
				}
			}
		}
		logger.info("Ending service getGamesByTitle");
		return result;
	}
	//necessario @transactional per la lazy initialization di Gioco.listaConsole
	@Transactional
	@RequestMapping(value = "/getGameByTitleAndConsole", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody GameSearchDTO getGamesByTitleAndConsole(@RequestParam(value = "titoloGioco") String titoloGioco, @RequestParam(value="nomeConsole") String nomeConsole) {
		logger.info("Starting service getGameByTitleAndConsole");
		GameSearchDTO result = new GameSearchDTO();
		Gioco response = new Gioco();
		if (!titoloGioco.equals("") && !titoloGioco.isEmpty() && !nomeConsole.equals("") && !nomeConsole.isEmpty()){
			response = giocoDao.getGameByTitleAndConsole(titoloGioco, nomeConsole);
				result.setTitolo(response.getTitoloGioco());
				result.setConsole(response.getListaConsoles().get(0).getNomeConsole());
		}
		logger.info("Ending service getGameByTitleAndConsole");
		return result;
	}
	@Transactional
	@RequestMapping(value = "/getGamesByConsole", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<GameSearchDTO> getGamesByConsole(@RequestParam(value="nomeConsole") String nomeConsole) {
		logger.info("Starting service getGamesByConsole");
		List<GameSearchDTO> result = new ArrayList<GameSearchDTO>();
		if(!nomeConsole.isEmpty() && !nomeConsole.equals("")){
			GameSearchDTO response = new GameSearchDTO();
			List<Gioco> listaGiochi = giocoDao.getGamesByConsole(nomeConsole);
			for(Gioco g : listaGiochi){
				response.setTitolo(g.getTitoloGioco());
				response.setConsole(g.getListaConsoles().get(0).getNomeConsole());
				result.add(response);
			}
			Collections.sort(result, new Comparator<GameSearchDTO>() {
				public int compare(GameSearchDTO o1, GameSearchDTO o2) {
					return o2.getConsole().compareTo(o1.getConsole());
				}
			});
		}
		logger.info("Ending service getGamesByConsole");
		return result;
	}
	@Transactional
	@RequestMapping(value = "/getConsolesByProductor", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<String> getConsolesByProductor(@RequestParam(value = "nomeProduttore") String nomeProduttore) {
		logger.info("Starting service getConsolesByProductor");
		List<String> result = new ArrayList<String>();
		if (!nomeProduttore.equals("") && !nomeProduttore.isEmpty()) {
			List<Console> listaConsole = consoleDao.getConsolesByProductor(nomeProduttore);
			for (Console c : listaConsole) {
					result.add(c.getNomeConsole());
			}
		}
		logger.info("Ending service getGamesByTitle");
		return result;
	}
}