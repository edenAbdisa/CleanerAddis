package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepos;
	
	public Article Save(Article article) {
		return articleRepos.save(article);
	}
	
	public List<Article> saveAll(List<Article> articles){
		return articleRepos.saveAll(articles);
	}
	
	public List<Article> findAll(){
		return articleRepos.findAll();
	}

	public Article findArticleById(UUID uuid) {
		return articleRepos.findById(uuid).get();
	}

	public void delete( Article article) {
		 articleRepos.delete(article);
	}
	
	public Article findArticleByTitle(String title) {
		return articleRepos.findArticleByTitle(title);
	}

}
