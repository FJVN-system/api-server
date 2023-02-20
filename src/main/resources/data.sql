
-- Company 컴퍼니
insert into company(company_id,
                    company_name,
                    owner,
                    created_at,
                    updated_at)
values ('hm-qwe',
        'HM',
        '만수',
        now(),
        now());

insert into company(company_id,
                    company_name,
                    owner,
                    created_at,
                    updated_at)
values ('inter-qwe',
        'INTER',
        '주',
        now(),
        now());

--- 유저 user
insert into users(users_id,
                  users_name,
                  company_id,
                  created_At,
                  updated_At)
values (22,
        '김경환',
        'hm-qwe',
        now(),
        now());


insert into users(users_id,
                  users_name,
                  company_id,
                  created_At,
                  updated_At)
values (33,
        '환',
        'inter-qwe',
        now(),
        now());

-- 아티스트 artist
insert into artist(artist_id,
                   artist_name,
                   company_id)
values (11,
        '진',
        'hm-qwe');
insert into artist(artist_id,
                   artist_name,
                   company_id)
values (22,
        '뷔',
        'inter-qwe');

-- 카테고리 category
insert into category(category_id,
                     category_name,
                     company_id)
values (11,
        '음반',
        'hm-qwe');

insert into category(category_id,
                     category_name,
                     company_id)
values (22,
        '굿즈',
        'inter-qwe');

-- 엔터 ent
insert into ent(ent_id,
                ent_name,
                company_id)
values (11,
        'SM',
        'hm-qwe');
insert into ent(ent_id,
                ent_name,
                company_id)
values (22,
        'hive',
        'inter-qwe');





-- 프로덕트 product
insert into product(product_id,
                    company_id,
                    artist_id,
                    category_id,
                    ent_id,
                    thumb_Nail_Url,
                    price,
                    weight,
                    title,
                    purchase_Price,
                    stock,
                    release_Date,
                    preorder_Deadline,
                    stock_Limited,
                    restockable,
                    sku,
                    barcode,
                    description,
                    created_At,
                    updated_At)
values (11,
        'hm-qwe',
        11,
        11,
        11,
        '섬네일 주소',
        10000,
        450,
        '다이나마이트',
        8000,
        90,
        now(),
        now(),
        false,
        false,
        '123-sdf',
        'sdfg-534',
        '상품 소개',
        now(),
        now());


insert into product(product_id,
                    company_id,
                    artist_id,
                    category_id,
                    ent_id,
                    thumb_Nail_Url,
                    price,
                    weight,
                    title,
                    purchase_Price,
                    stock,
                    release_Date,
                    preorder_Deadline,
                    stock_Limited,
                    restockable,
                    sku,
                    barcode,
                    description,
                    created_At,
                    updated_At)
values (22,
        'inter-qwe',
        22,
        22,
        22,
        '섬네일 주소',
        100000,
        4500,
        '피규어',
        80000,
        900,
        now(),
        now(),
        true,
        true,
        'sdf',
        '534',
        '상품 소개',
        now(),
        now());


-- 프로덕트 메모 productmemo
insert into productMemo(productmemo_id,
                        product_id,
                        content,
                        created_At,
                        updated_At)
values (11,
        11,
        '중요한 상품',
        now(),
        now());

insert into productMemo(productmemo_id,
                        product_id,
                        content,
                        created_At,
                        updated_At)
values (22,
        11,
        '안좋은 상품',
        now(),
        now());

insert into productMemo(productmemo_id,
                        product_id,
                        content,
                        created_At,
                        updated_At)
values (33,
        22,
        '인터 상품',
        now(),
        now());



--스톡 히스토리 stockhistory
insert into stockHistory(stockhistory_id,
                        product_id,
                        company_id,
                        content,
                        created_At,
                        updated_At)
values (11,
        22,
        'inter-qwe',
        '안좋은 상품',
        now(),
        now());
insert into stockHistory(stockhistory_id,
                         product_id,
                         company_id,
                         content,
                         created_At,
                         updated_At)
values (22,
        11,
        'hm-qwe',
        '좋은 상품',
        now(),
        now());

-- 카트 아이템 cartsitem
insert into cartsitem(cartsitem_id,
                      product_id,
                      users_id,
                      price,
                      qty,
                      created_At,
                      updated_At)
values (22,
        11,
        22,
        20000,
        2,
        now(),
        now());

insert into cartsitem(cartsitem_id,
                      product_id,
                      users_id,
                      price,
                      qty,
                      created_At,
                      updated_At)
values (33,
        22,
        22,
        300000,
        3,
        now(),
        now());

insert into cartsitem(cartsitem_id,
                      product_id,
                      users_id,
                      price,
                      qty,
                      created_At,
                      updated_At)
values (44,
        11,
        33,
        30000,
        3,
        now(),
        now());

insert into cartsitem(cartsitem_id,
                      product_id,
                      users_id,
                      price,
                      qty,
                      created_At,
                      updated_At)
values (55,
        22,
        33,
        100000,
        1,
        now(),
        now());

-- 오더 order
insert into ordersitem(ordersitem_id,
                       product_id,
                       users_id,
                       price,
                       qty,
                       shipped,
                       created_At,
                       updated_At)
values (22,
        11,
        22,
        20000,
        2,
        false,
        now(),
        now());


insert into ordersitem(ordersitem_id,
                       product_id,
                       users_id,
                       price,
                       qty,
                       shipped,
                       created_At,
                       updated_At)
values (33,
        22,
        22,
        300000,
        3,
        true,
        now(),
        now());

-- 주소 address
insert into address(address_id,
                    users_id,
                    zipcode,
                    phone_number,
                    address_name,
                    address1,
                    address2,
                    address3,
                    state,
                    city,
                    created_At,
                    updated_At)
values (333,
        22,
        888888,
        01047634695,
        '우리집',
        '서울시',
        '관악구',
        '봉천동',
        'seoul',
        'seoul2',
        now(),
        now());




-- 배송 shipping
insert into shipping(shipping_id,
                     users_id,
                     company_id,
                     total_price,
                     shipping_price,
                     items_price,
                     total_count,
                     items_count,
                     Shipped_address_name,
                     shipping_type,
                     shipped_at,
                     address_id,
                     created_At,
                     updated_At)
values (33,
        22,
        'inter-qwe',
        300000,
        3000,
        297000,
        10,
        30,
        '우리집',
        '대한통운',
        now(),
        333,
        now(),
        now());


-- 배송상품 shippingItems
insert into shippingitems(shippingitems_id,
                          shipping_id,
                          users_id,
                          product_id,
                          price,
                          qty,
                          created_At,
                          updated_At)
values (33667,
        33,
        22,
        11,
        30000,
        3,
        now(),
        now());
insert into shippingitems(shippingitems_id,
                          shipping_id,
                          users_id,
                          product_id,
                          price,
                          qty,
                          created_At,
                          updated_At)
values (3366732,
        33,
        22,
        22,
        20000,
        2,
        now(),
        now());



-- 크레딧 credit
insert into credit(credit_id,
                   users_id,
                   company_id,
                   shipping_id,
                   content,
                   memo,
                   deposit,
                   withdraw,
                   balance,
                   created_At,
                   updated_At)
values (3366753,
        22,
        'inter-qwe',
        33,
        '발송',
        '첫주문',
        30000,
        0,
        -30000,
        now(),
        now());
insert into credit(credit_id,
                   users_id,
                   company_id,
                   shipping_id,
                   content,
                   memo,
                   deposit,
                   withdraw,
                   balance,
                   created_At,
                   updated_At)
values (33667533,
        22,
        'inter-qwe',
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
        now(),
        now());
