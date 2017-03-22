package it.recensigames.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.recensigames.dao.DomandaDao;
import it.recensigames.dao.RecensioneDao;
import it.recensigames.dao.RispostaDao;
import it.recensigames.dto.AnswerDTO;
import it.recensigames.dto.GameSearchDTO;
import it.recensigames.dto.PartialReviewDTO;
import it.recensigames.dto.QuestionDTO;
import it.recensigames.model.Domanda;
import it.recensigames.model.Recensione;
import it.recensigames.model.Risposta;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private DomandaDao domandaDao;
	@Autowired
	private RecensioneDao recensioneDao;
	@Autowired
	private RispostaDao rispostaDao;
	private Logger logger = Logger.getLogger(ProfileController.class);
	
	@Transactional
	@RequestMapping(value = "/getQuestionsByUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<QuestionDTO> getQuestionsByUser(@RequestParam(value = "username") String username){
		logger.info("Starting service getQuestionsByUser");
		List<QuestionDTO> listaDTO = new ArrayList<QuestionDTO>();
		if(!username.isEmpty() && !username.equals("")){
			QuestionDTO dto;
			List<Domanda> listaDomande = new ArrayList<Domanda>();
			listaDomande = domandaDao.getQuestionsByUser(username);
			GameSearchDTO gameDTO;
			for(Domanda d : listaDomande){
				dto = new QuestionDTO();
				gameDTO = new GameSearchDTO();
				dto.setData(d.getData());
				dto.setDescrizione(d.getTesto());
				dto.setTitolo(d.getTitolo());
				gameDTO.setConsole(d.getConsole().getNomeConsole());
				gameDTO.setTitolo(d.getGioco().getTitoloGioco());
				dto.setGameDTO(gameDTO);
				listaDTO.add(dto);
			}
		}
		logger.info("Starting service getQuestionsByUser");
		return listaDTO;
	}
	@Transactional
	@RequestMapping(value = "/getPartialReviewsByUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<PartialReviewDTO> getPartialReviewsByUser(@RequestParam(value = "username") String username){
		logger.info("Starting service getPartialReviewsByUser");
		List<PartialReviewDTO> listaDTO = new ArrayList<PartialReviewDTO>();
		if(!username.isEmpty() && !username.equals("")){
			PartialReviewDTO dto;
			List<Recensione> listaRecensioni = new ArrayList<Recensione>();
			listaRecensioni = recensioneDao.getReviewsByUser(username);
			for(Recensione r : listaRecensioni){
				dto = new PartialReviewDTO();
				dto.setNomeConsole(r.getConsole().getNomeConsole());
				dto.setNomeGioco(r.getGioco().getTitoloGioco());
				dto.setTitoloRecensione(r.getTitoloRecensione());
				dto.setImg(r.getGioco().getCopertina());
				dto.setTipologia(r.getTipologia());
				listaDTO.add(dto);
			}
		}
		logger.info("Ending service getPartialReviewsByUser");
		return listaDTO;
	}
	@Transactional
	@RequestMapping(value = "/getAnswersByUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<AnswerDTO> getAnswersByUser(@RequestParam(value = "username") String username){
		logger.info("Starting service getAnswersByUser");
		List<AnswerDTO> listaDTO = new ArrayList<AnswerDTO>();
		if(!username.isEmpty() && !username.equals("")){
			AnswerDTO dto;
			GameSearchDTO gameDto;
			List<Risposta> listaRisposte = new ArrayList<Risposta>();
			listaRisposte = rispostaDao.getAnswersByUser(username);
			for(Risposta r : listaRisposte){
				dto = new AnswerDTO();
				gameDto = new GameSearchDTO();
				dto.setTitoloDomanda(r.getDomanda().getTitolo());
				dto.setTestoRisposta(r.getTesto());
				dto.setData(r.getData());
				gameDto.setTitolo(r.getDomanda().getGioco().getTitoloGioco());
				gameDto.setConsole(r.getDomanda().getConsole().getNomeConsole());
				dto.setGameDTO(gameDto);
				listaDTO.add(dto);
			}
		}
		logger.info("Ending service getAnswersByUser");
		return listaDTO;
	}
}