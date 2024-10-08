package com.doranco.inscicecom.services.admin.faq;

import com.doranco.inscicecom.dto.FAQDto;
import com.doranco.inscicecom.model.FAQ;
import com.doranco.inscicecom.model.Product;
import com.doranco.inscicecom.repository.FAQRepository;
import com.doranco.inscicecom.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FAQServiceImplTest {

    AutoCloseable autoCloseable;
    @Mock
    FAQRepository faqRepository;
    @Mock
    ProductRepository productRepository;

    private FAQService faqService;

    private FAQDto faqDto;
    private Product product;
    private FAQ faq;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        faqService = new FAQServiceImpl(faqRepository, productRepository);

        product = Product.builder().id(1L).build();

        faq = FAQ.builder()
                .id(1L)
                .product(product)
                .build();

        faqDto = FAQDto.builder()
                .id(1L)
                .answer("demo")
                .productId(product.getId())
                .question("demo")
                .build();

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void postFAQ() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(faqRepository.save(any())).thenReturn(faq);
        FAQDto savedFAQ = faqService.postFAQ(product.getId(), faqDto);
        // Assertions
        assertNotNull(savedFAQ, "Saved FAQ should not be null");
        assertEquals(faqDto.getId(), savedFAQ.getId(), "FAQ ID should match");

        // Verify method invocation
        verify(faqRepository).save(any(FAQ.class));
    }
}