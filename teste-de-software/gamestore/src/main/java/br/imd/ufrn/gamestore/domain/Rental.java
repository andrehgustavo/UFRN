package br.imd.ufrn.gamestore.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author Eiji Adachi
 *
 */
public class Rental {
	private User user;

	private List<Game> games;

	private LocalDate rentalDate;

	private LocalDate returnDate;

	private Double price;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Rental other = (Rental) obj;
		if (games == null) {
			if (other.games != null) {
				return false;
			}
		} else if (!games.equals(other.games)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (rentalDate == null) {
			if (other.rentalDate != null) {
				return false;
			}
		} else if (!rentalDate.equals(other.rentalDate)) {
			return false;
		}
		if (returnDate == null) {
			if (other.returnDate != null) {
				return false;
			}
		} else if (!returnDate.equals(other.returnDate)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	public List<Game> getGames() {
		return games;
	}

	public Double getPrice() {
		return price;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public User getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((games == null) ? 0 : games.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rentalDate == null) ? 0 : rentalDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Rental [user=" + user + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate + ", price=" + price
				+ "]";
	}
}
