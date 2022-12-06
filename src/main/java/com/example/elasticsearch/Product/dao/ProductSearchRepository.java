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

    @Query(" {\n" +
            "\n" +
            "    \"bool\": {\n" +
            "\n" +
            "      \"must\": {\n" +
            "\n" +
            "        \"dis_max\": {\n" +
            "\n" +
            "          \"queries\": [{ \"match\": { \"name_nori\": \"?0\" }},\n" +
            "        { \"match\": { \"display_name_nori\": \"?1\" }},\n" +
            "        { \"match\": { \"description_nori\": \"?2\" }}],\n" +
            "        \"tie_breaker\": 0.7\n" +
            "\n" +
            "          }\n" +
            "\n" +
            "      }\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "  }")
    List<ProductDocument> findByNameOrDisplayNameOrDescription(String name, String displayName, String description);


    List<ProductDocument> findByNameContainsOrDisplayNameContainsOrDescriptionContains(String name, String displayName, String description);
}
