package com.ojtproject.phonebook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ojtproject.phonebook.entity.PhoneBookPh2Entity;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookPh2Entity, Long> {

	/**検索SQL*/
	@Query(value = "SELECT p.id, p.name, p.phone_number,p.address FROM phone_book_ph2 p ORDER BY p.id", nativeQuery = true)
	public List<PhoneBookPh2Entity> findAll();

	@Query(value = "SELECT p.id,  p.name, p.phone_number,p.address FROM phone_book_ph2 p "
			+ "WHERE p.name LIKE %:keyword% OR p.phone_number LIKE %:keyword% ORDER BY p.id", nativeQuery = true)
	public List<PhoneBookPh2Entity> find(@Param("keyword")String keyword);

	/**削除SQL*/
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM phone_book_ph2 p WHERE p.id = :id", nativeQuery = true)
	public void delete(@Param("id")int id);

	/**登録SQL*/
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO phone_book_ph2 (name,phone_number, address) VALUES (:name,:phoneNumber, :address)", nativeQuery = true)
	public void regist(@Param("name")String name, @Param("phoneNumber")String phoneNumber, @Param("address")String address);

	/**更新SQL*/
	@Modifying
	@Transactional
	@Query(value = "UPDATE phone_book_ph2 SET name = :name, phone_number = :phoneNumber, address = :address WHERE id = :id", nativeQuery = true)
	public void update(@Param("id")int id, @Param("name")String name, @Param("phoneNumber")String phoneNumber, @Param("address")String address);
}