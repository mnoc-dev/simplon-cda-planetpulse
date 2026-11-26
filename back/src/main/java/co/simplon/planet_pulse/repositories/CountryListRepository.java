package co.simplon.planet_pulse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.planet_pulse.dtos.CountryListItem;
import co.simplon.planet_pulse.entities.Country;

// Access country data in the database.
public interface CountryListRepository extends JpaRepository<Country, Integer> {

    // Return country names, codes, and flags sorted by name.
    @Query("select new co.simplon.planet_pulse.dtos.CountryListItem(c.countryName, c.isoCode, c.urlFlag) "
            + "from Country c order by c.countryName")
    List<CountryListItem> findAllForList();
}
