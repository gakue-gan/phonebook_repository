package com.ojtproject.phonebook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ojtproject.phonebook.entity.PhoneBookEntity;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Long> {

	/**検索SQL*/
	@Query(value = "SELECT p.phone_book_id, p.name, p.phone_number, false as is_deleted FROM phone_book p", nativeQuery = true)
	public List<PhoneBookEntity> findAll();

	@Query(value = "SELECT p.phone_book_id, p.name, p.phone_number, false as is_deleted FROM phone_book p "
			+ "WHERE p.name LIKE %:keyword% OR p.phone_number LIKE %:keyword%", nativeQuery = true)
	public List<PhoneBookEntity> find(@Param("keyword")String keyword);

	/**削除SQL*/
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM phone_book WHERE phone_book_id = :id", nativeQuery = true)
	public void delete(@Param("id")int id);

	/**登録SQL*/
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO phone_book (name,phone_number) VALUES (:name,:phoneNumber)", nativeQuery = true)
	public void regist(@Param("name")String name, @Param("phoneNumber")String phoneNumber);

	/**更新SQL*/
	@Modifying
	@Transactional
	@Query(value = "UPDATE phone_book SET name = :name, phone_number = :phoneNumber WHERE phone_book_id = :id", nativeQuery = true)
	public void update(@Param("id")int id, @Param("name")String name, @Param("phoneNumber")String phoneNumber);
}