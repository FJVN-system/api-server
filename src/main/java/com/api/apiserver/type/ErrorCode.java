package com.api.apiserver.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생했습니다."),
    INVALID_REQUEST("잘못된 요청입니다."),
//    TRANSACTION_NOT_FOUND("해당 거래가 없습니다."),
//    AMOUNT_EXCEED_BALANCE("거래 금액이 계좌 잔액보다 큽니다."),
//    AMOUNT_TRANSACTION_LOCK("해당 계좌는 사용 중입니다."),
//    USER_ACCOUNT_UN_MATCH("사용자와 계좌의 소유주가 다릅니다."),
//    TRANSACTION_ACCOUNT_UN_MATCH("이 거래는 해당 계좌에서 발생한 거래가 아닙니다."),
//    CANCEL_MUST_FULLY("부분 취소는 허용되지 않습니다."),
//    TOO_OLD_ORDER_TO_CANCEL("1년이 지난 거래는 취소가 불가능합니다."),
//    ACCOUNT_ALREADY_UNREGISTERED("계좌가 이미 해지되었습니다."),
//    BALANCE_NOT_EMPTY("잔액이 있는 계좌는 해지할 수 없습니다."),
//    MAX_ACCOUNT_PER_USER_10("사용자 최대 계좌는 10개 입니다."),
//    ACCOUNT_NOT_FOUND("계좌가 없습니다."),
//--------------------------------------------------------------------------
    PRODUCT_NOT_FOUND("해당 상품이 없습니다."),
    ORDER_QTY_EXCEED_STOCK("재고가 부족합니다"),
    CART_ITEM_NOT_FOUND("장바구니에 없습니다."),
    CART_ITEMS_NOT_FOUND("장바구니에 상품이 없습니다."),
    ALREADY_ADDED_ON_CART("해당 상품이 이미 장바구니에 있습니다."),
    USER_NOT_FOUND("해당 유저가 없습니다."),
    ARTIST_NOT_FOUND("해당 가수가 없습니다."),
    CATEGORY_NOT_FOUND("해당 카테고리가 없습니다."),

    ENT_NOT_FOUND("해당 소속사가 없습니다."),

    PRODUCTMEMO_NOT_FOUND("해당 상품의 메모가 없습니다");

    private final String Description;


}
