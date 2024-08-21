package com.doranco.inscicecom.services.admin.faq;

import com.doranco.inscicecom.dto.FAQDto;

public interface FAQService {
	FAQDto postFAQ(Long productId, FAQDto faqDto);
}
