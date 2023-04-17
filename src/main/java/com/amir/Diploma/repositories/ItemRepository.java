package com.amir.Diploma.repositories;

import com.amir.Diploma.models.Item;
import com.amir.Diploma.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByTitle(String title);

    List<Item> findAllByAuthor(User user);


}
