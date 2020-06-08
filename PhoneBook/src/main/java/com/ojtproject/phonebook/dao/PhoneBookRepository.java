package com.ojtproject.phonebook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ojtproject.phonebook.entity.PhoneBookEntity;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Long> {

	/**検索SQL*/
	@Query(value = "SELECT p.phone_book_id, p.name, p.phone_number, false as is_deleted FROM phone_book p", nativeQuery = true)
	public List<PhoneBookEntity> findAll();

	/**削除SQL*/
	@Modifying
	@Transactional
	@Query(value = "DELETE from phone_book WHERE phone_book_id = :id", nativeQuery = true)
	public void delete(int id);

	/**登録SQL*/
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO phone_book (name,phone_number,phone_book_id) VALUES (:name,:phoneNumber,:phoneBookId)", nativeQuery = true)
	public void regist(String name, String phoneNumber, String accountId);

	/**更新SQL*/
	@Modifying
	@Transactional
	@Query(value = "UPDATE phone_book SET name = :name, phone_number = :phoneNumber ,phone_book_id = :id WHERE phone_book_id = :id", nativeQuery = true)
	public void update(String name, String phoneNumber, int id, String accountId);
}