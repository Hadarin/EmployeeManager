package com.hadrin.employeedemo.dao;

import com.hadrin.employeedemo.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository provides DAO for the Language entity.
 * @author Igor Hadarin
 * @version 1.0
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findByLanguageName(String language);

}
