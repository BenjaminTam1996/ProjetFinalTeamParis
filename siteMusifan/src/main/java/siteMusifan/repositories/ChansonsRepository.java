package siteMusifan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Chansons;



public interface ChansonsRepository extends JpaRepository<Chansons, Long>{
	@Transactional
	List<Chansons> findByChansonsContaining(String chansons);
}
