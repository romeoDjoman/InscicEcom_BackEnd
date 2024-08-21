package com.doranco.inscicecom.services.admin.faq;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doranco.inscicecom.dto.FAQDto;
import com.doranco.inscicecom.model.FAQ;
import com.doranco.inscicecom.model.Product;
import com.doranco.inscicecom.repository.FAQRepository;
import com.doranco.inscicecom.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FAQServiceImpl implements FAQService {
	private final FAQRepository faqRepository;

	private final ProductRepository productRepository;

	public FAQDto postFAQ(Long productId, FAQDto faqDto) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()) {
			FAQ faq = new FAQ();
			faq.setQuestion(faqDto.getQuestion());
			faq.setAnswer(faqDto.getAnswer());
			faq.setProduct(optionalProduct.get());

			FAQ savedFAQ = faqRepository.save(faq);
			log.info("FAQ posted successfully for product with ID: {}", productId);
			return savedFAQ.getFAQDto();
		}

		log.warn("Failed to post FAQ. Product with ID {} not found.", productId);
		return null;
	}

}
