package com.example.elasticsearch.Product.dao;

import com.example.elasticsearch.Product.domain.ProductDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductSearchRepository extends ElasticsearchRepository<ProductDocument, Long> {
    List<ProductDocument> findAll();

    List<ProductDocument> findAllByOrderByIdAsc();

    List<ProductDocument> findByDescription(String description);

    List<ProductDocument> findByDescriptionAndDisplayName(String description, String displayName);

    @Query("{\"match\": [{\"name_nori\": {\"query\": \"?0\"}, {\"display_name_nori\": {\"query\": \"?1\"}, {\"description_nori\": {\"query\": \"?2\"}}]}")
    List<ProductDocument> findByNameOrDisplayNameOrDescription(String name, String displayName, String description);


    List<ProductDocument> findByNameContainsOrDisplayNameContainsOrDescriptionContains(String name, String displayName, String description);
}
