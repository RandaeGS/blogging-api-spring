package com.blogging.bloggingapispring.repositories;

import com.blogging.bloggingapispring.encapsulations.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article, UUID> {

}
