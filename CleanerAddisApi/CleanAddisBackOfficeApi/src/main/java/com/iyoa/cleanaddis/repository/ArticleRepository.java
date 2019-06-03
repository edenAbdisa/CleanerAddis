package com.iyoa.cleanaddis.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Article;


public interface ArticleRepository extends JpaRepository<Article, UUID> {

	// List<Article> searchByTitle(String title);
	
	Article findBytitle(String title);
	

	
	List<Article> findBySummaryText(String summaryText);
	
	Article findByUuid(UUID uuid);
	
	//List<Article> findByCategory(Category category);

	int countAllByFeaturedIsTrue();
	
	@Query(value = "SELECT * "
			+ "FROM articles "
			+ "WHERE "
			+ "(title LIKE CONCAT('%', :squery, '%')) "
			+ "OR "
			+ "(summary_text LIKE CONCAT('%', :squery, '%')) "
			+ "ORDER BY updated_at DESC"
			,nativeQuery = true)
		List<Article> autocomplWithSQL(@Param("squery") String query);
	
	@Query(value = "SELECT * "
			+ "FROM articles "
			+ "WHERE "
			+ "((title RLIKE CONCAT(:squery)) "
			+ "OR "
			+ "(summary_text RLIKE CONCAT(:squery))) "
			+ "AND (published = 1) "
			+ "ORDER BY updated_at DESC "
			+ "LIMIT :from, :to"
			,nativeQuery = true)
		List<Article> searchPaginWithSQL(@Param("squery") String query, 
											@Param("from") int limitFrom, 
											@Param("to") int limitTo);
	
	@Query(value = "SELECT * "
			+ "FROM articles "
			+ "WHERE "
			+ "((title LIKE CONCAT('%', :squery, '%')) "
			+ "OR "
			+ "(summary_text LIKE CONCAT('%', :squery, '%'))) "
			+ "AND published = 1 "
			+ "AND updated_at "
			+ "BETWEEN :from AND :to "
			+ "ORDER BY updated_at DESC"
			,nativeQuery = true)
		List<Article> filterSearchWithSQL(@Param("squery") String query, 
											   @Param("from") Date from, 
											   @Param("to") Date to);

  
	/**
	 * Gets a list of articles filtered by category and date
	 * an original article uuid can be filtered out
	 * @param from the date to start filter by
	 * @param category the category to filter
	 * @param uuid the uuid of the origin article to ignore
	 * @return a list of valid articles
	 */
	@Query(value = "SELECT * FROM articles "
		+ "WHERE category_id = :category AND published = 1 AND uuid <> :id "
		+ "AND created_at > :from "
		,nativeQuery = true)
	List<Article> findPublishedArticlesByCategoryAndDate(@Param("from") String from, @Param("category") UUID category, @Param("id") UUID uuid);
	
	/**
	 * Method to get a list of articles filtered by category and date
	 * without providing an article UUID
	 * @param from the date to start filtering by
	 * @param category the category to filter
	 * @return a list of valid articles
	 */
	@Query(value = "SELECT * FROM articles "
		+ "WHERE category_id = :category AND published = 1 "
		+ "AND created_at > :from "
		,nativeQuery = true)
	List<Article> findPublishedArticlesByCategoryAndDateWithoutUUID(@Param("from") String from, @Param("category") UUID category);
	
	/**
	 * Returns the newest 20, or less published articles from a category
	 * @param category the category to search
	 * @return a list of articles
	 */
	@Query(value = "SELECT * FROM articles "
		+ "WHERE category_id = :category AND published = 1 "
		+ "ORDER BY updated_at DESC "
		+ "LIMIT 20 "
		,nativeQuery = true)
	List<Article> findNewestPublishedArticlesByCategory(@Param("category") UUID category);
	
}