package by.itstep.clothesshop.repository;

import by.itstep.clothesshop.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    List<Basket> findAllByUserId(Integer userId);
}