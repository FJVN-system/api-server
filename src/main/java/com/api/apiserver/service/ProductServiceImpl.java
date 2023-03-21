package com.api.apiserver.service;

import com.api.apiserver.DTO.product.CreateProduct;
import com.api.apiserver.DTO.product.CreateProductBulk;
import com.api.apiserver.DTO.product.ProductsDTO;
import com.api.apiserver.domain.*;
import com.api.apiserver.exception.ArtistException;
import com.api.apiserver.exception.CategoryException;
import com.api.apiserver.exception.EntException;
import com.api.apiserver.exception.ProductException;
import com.api.apiserver.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.api.apiserver.type.ErrorCode.*;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ArtistService artistService;
    private final CategoryService categoryService;
    private final EntService entService;
    private final ProductRepository productRepository;
    private final CompanyRepository companyRepository;
    private final ArtistRepository artistRepository;
    private final CategoryRepository categoryRepository;
    private final EntRepository entRepository;


    // TODO 테스트코드 작성필요
    @Transactional
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(PRODUCT_NOT_FOUND));
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<ProductsDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductsDTO::new)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<ProductsDTO> getAllProductsByCompanyId(Long companyId) {
        List<Product> products = productRepository.findByCompany_Id(companyId);
        return products
                .stream()
                .map(ProductsDTO::new)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<ProductsDTO> getAllProductsByCompanyIdAndCategory(Long companyId, String category) {
        List<Product> products = productRepository.findByCompany_IdAndCategory_Name(companyId, category);
        return products
                .stream()
                .map(ProductsDTO::new)
                .toList();
    }

    // TODO 테스트코드 작성필요
    @Override
    public List<Product> createProductsBulk(List<CreateProductBulk.Request> requests, Long companyId) {
        Company company = companyRepository.findById(companyId);

        List<Product> products = requests.stream().map(request ->
                Product.builder()
                        .company(company)
                        .title(request.getTitle())
                        .barcode(request.getBarcode())
                        .price(request.getPrice())
                        .description(request.getDesc())
                        .purchasePrice(request.getPurchase())
                        .preorderDeadline(request.getDeadline())
                        .releaseDate(request.getRelease())
                        .sku(request.getSku())
                        .stock(request.getStock())
                        .thumbNailUrl(request.getThumb())
                        .weight(request.getWeight())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .artist(artistService.getOrCreateArtistByCompanyIdAndArtistName(companyId, request.getArtist()))
                        .category(categoryService.getOrCreateCategoryByCompanyIdAndCategoryName(companyId, request.getCategory()))
                        .ent(entService.getOrCreateEntByCompanyIdAndEntName(companyId, request.getEnt()))
                        .build()).toList();

        List<Product> saveAll = productRepository.saveAll(products);
        return saveAll;
    }

    @Override
    public Product createProduct(CreateProduct.Request requests,Long companyId) {
        Company company = companyRepository.findById(companyId);

        return productRepository.save(Product.builder()
                .title(requests.getTitle())
                .company(company)
                .barcode(requests.getBarcode())
                .price(requests.getPrice())
                .description(requests.getDesc())
                .purchasePrice(requests.getPurchase())
                .preorderDeadline(requests.getDeadline())
                .releaseDate(requests.getRelease())
                .sku(requests.getSku())
                .stock(requests.getStock())
                .thumbNailUrl(requests.getThumb())
                .weight(requests.getWeight())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .artist(artistRepository.findById(requests.getArtist())
                        .orElseThrow(() -> new ArtistException(ARTIST_NOT_FOUND)))
                .category(categoryRepository.findById(requests.getCategory())
                        .orElseThrow(() -> new CategoryException(CATEGORY_NOT_FOUND)))
                .ent(entRepository.findById(requests.getEnt())
                        .orElseThrow(() -> new EntException(ENT_NOT_FOUND)))
                .build());
    }

}
