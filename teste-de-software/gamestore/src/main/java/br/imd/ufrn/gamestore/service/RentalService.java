package br.imd.ufrn.gamestore.service;

import java.time.LocalDate;
import java.util.List;

import br.imd.ufrn.gamestore.domain.Game;
import br.imd.ufrn.gamestore.domain.Rental;
import br.imd.ufrn.gamestore.domain.User;

/**
 * 
 * @author Eiji Adachi
 *
 */
public class RentalService {

	/**
	 *
	 * @param user
	 * @param games
	 * @return
	 */
	public Rental registerRental(User user, List<Game> games) {
		final Rental rental = new Rental();
		rental.setGames(games);
		rental.setUser(user);

		final LocalDate now = LocalDate.now();

		// Exemplo de como adicionar dias
		rental.setReturnDate(now.plusDays(1));
		
		// Tem que atribuir o valor do empréstimo também 
		rental.setPrice(100.0d);

		return rental;
	}
}
