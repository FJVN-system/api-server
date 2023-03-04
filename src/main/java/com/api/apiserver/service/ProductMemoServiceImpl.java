package com.api.apiserver.service;

import com.api.apiserver.DTO.ProductMemo.ProductMemoDto;
import com.api.apiserver.DTO.ProductMemo.ProductMemoPatchDto;
import com.api.apiserver.DTO.ProductMemo.ProductMemoPostDto;
import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.ProductMemo;
import com.api.apiserver.domain.Users;
import com.api.apiserver.exception.ProductMemoException;
import com.api.apiserver.repository.ProductMemoRepository;
import com.api.apiserver.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductMemoServiceImpl implements ProductMemoService {

    private final ProductMemoRepository productMemoRepository;

    private final ProductService productService;

    private final UsersService usersService;

    @Override
    public List<ProductMemoDto> getProductMemoByProductId(Long productId) {
        List<ProductMemo> productMemos = productMemoRepository.findAllByProduct_Id(productId);

        List<ProductMemoDto> productMemoDto = productMemos.stream()
                .map(productMemo ->
                        new ProductMemoDto(
                                productMemo.getProductMemoId(),
                                productMemo.getCreatedAt(),
                                productMemo.getUsers().getId(),
                                productMemo.getUpdatedAt()))
                .collect(Collectors.toList());
        return productMemoDto;
    }


    public void deleteProductMemo(Long productMemoId) {

        ProductMemo findProductMemo = findVerifiedProductMemo(productMemoId);

        productMemoRepository.deleteById(findProductMemo.getProductMemoId());
        //메모를 삭제해야한다
        //메모 Id를 삭제하여 메모를 삭제한다

    }


//    public ProductMemo updateProductMemo(ProductMemoPatchDto productMemoPatchDto) {
//       ProductMemo findProductMemo = findVerifiedProductMemo(productMemoPatchDto.getProductMemoId());
//
//       Optional.ofNullable(productMemoPatchDto.getMemoUser())
//               .ifPresent(memoUser -> findProductMemo.setUsers(us));
//       Optional.ofNullable(productMemoPatchDto.getContent())
//                .ifPresent(content -> findProductMemo.setContent(content));
//       findProductMemo.setUpdatedAt(LocalDateTime.now());
//
//        return productMemoRepository.save(findProductMemo);
//    }

    public ProductMemo findVerifiedProductMemo(Long productMemoId) {
        Optional<ProductMemo> optionalProductMemo =
                productMemoRepository.findById(productMemoId);

        ProductMemo findProductMemo =
                optionalProductMemo.orElseThrow(() ->
                        new ProductMemoException(ErrorCode.PRODUCTMEMO_NOT_FOUND));
        return findProductMemo;
    }

    public ProductMemo setProductMemo(ProductMemoPostDto productMemoPostDto) {

        Product product = productService.getProduct(productMemoPostDto.getProductId());
        LocalDateTime createdAt = LocalDateTime.now();
        Users users = usersService.getUser(productMemoPostDto.getUsersId());
        LocalDateTime updatedAt = LocalDateTime.now();
        String content = productMemoPostDto.getMemo();

        ProductMemo productMemo = new ProductMemo(product, createdAt, users, updatedAt, content);

        ProductMemo save = productMemoRepository.save(productMemo);

        return save;


//    @Override
//    public ProductMemo setProductMemo(ProductMemoPostDto productMemoPostDto) {

//        Product product = productService.getProduct(productMemoPostDto.getProductId());
//        LocalDateTime createdAt = LocalDateTime.now();
//        String memoUser = "김아무개";
//        LocalDateTime updatedAt = LocalDateTime.now();
//        String content = productMemoPostDto.getMemo();
//
//        ProductMemo productMemo = new ProductMemo(product, createdAt, memoUser, updatedAt, content);
//        ProductMemo save = productMemoRepository.save(productMemo);

//        return productMemoRepository.save(new ProductMemo(
//                productService.getProduct(productMemoPostDto.getProductId()),
//                LocalDateTime.now(),
//                "김아무개",
//                LocalDateTime.now(),
//                productMemoPostDto.getMemo()


//        return productMemoRepository.save(
//                ProductMemo.builder()
//                        .memoUser("김아무개")
//                        .content(productMemoPostDto.getMemo())
//                        .updatedAt(LocalDateTime.now())
//                        .createdAt(LocalDateTime.now())
//                        .product(productService.getProduct(productMemoPostDto.getProductId()))
//                        .build());
    }
}