
-- Company 컴퍼니
insert into company(company_id,
                    company_name,
                    owner,
                    store_url,
                    created_at,
                    updated_at)
values (11111,
        'HM',
        '만수',
        'https://www.naver.com',
        now(),
        now());

insert into company(company_id,
                    company_name,
                    owner,
                    store_url,
                    created_at,
                    updated_at)
values (22222,
        'INTER',
        '주',
        'https://www.google.com',
        now(),
        now());





-- 카테고리 category
insert into category(category_id,
                     category_name,
                     company_id)
values (11111,
        '음반',
        11111);

insert into category(category_id,
                     category_name,
                     company_id)
values (22222,
        '굿즈',
        22222);

-- 유저별 할인
insert into discountbyuser(discountbyuser_id,
                           company_id,
                           rate,
                           amount,
                           created_At,
                           updated_At)
values (1010,
        22222,
        20,
        2000,
        now(),
        now());

insert into discountbyuser(discountbyuser_id,
                           company_id,
                           rate,
                           amount,
                           created_At,
                           updated_At)
values (1000,
        11111,
        10,
        1000,
        now(),
        now());





--- 유저 user
insert into users(users_id,
                  users_name,
                  company_id,
                  discountbyuser_id,
                  users_email,
                  created_At,
                  updated_At)
values (22,
        '김경환',
        11111,
        1000,
        'rudghksldl@gmail.com',
        now(),
        now());

insert into users(users_id,
                  users_name,
                  company_id,
                  discountbyuser_id,
                  users_email,
                  created_At,
                  updated_At)
values (33,
        '환',
        22222,
        1010,
        'kkhdevs@gmail.com',
        now(),
        now());


-- 카테고리별 할인
insert into discountbycategory(discountbycategory_id,
                               users_id,
                               category_id,
                               company_id,
                               rate,
                               amount,
                               created_At,
                               updated_At)
values (10000,
        22,
        11111,
        11111,
        5,
        5000,
        now(),
        now());


insert into discountbycategory(discountbycategory_id,
                               users_id,
                               category_id,
                               company_id,
                               rate,
                               amount,
                               created_At,
                               updated_At)
values (10020,
        33,
        22222,
        22222,
        15,
        15000,
        now(),
        now());







-- 아티스트 artist
insert into artist(artist_id,
                   artist_name,
                   company_id)
values (111111,
        '진',
        11111);
insert into artist(artist_id,
                   artist_name,
                   company_id)
values (222222,
        '뷔',
        22222);



-- 엔터 ent
insert into ent(ent_id,
                ent_name,
                company_id)
values (1111,
        'SM',
        11111);
insert into ent(ent_id,
                ent_name,
                company_id)
values (2222,
        'hive',
        22222);





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
values (99999,
        11111,
        111111,
        11111,
        1111,
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
values (88888,
        11111,
        111111,
        11111,
        1111,
        'https://c.files.bbci.co.uk/6BEE/production/_125403672_gettyimages-1207828603.jpg',
        100000,
        450,
        '재고 900개 짜리 상품',
        8000,
        900,
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
values (88889,
        11111,
        111111,
        11111,
        1111,
        'https://c.files.bbci.co.uk/6BEE/production/_125403672_gettyimages-1207828603.jpg',
        100000,
        450,
        '재고 5개 짜리 상품',
        8000,
        5,
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
values (88887,
        11111,
        111111,
        11111,
        1111,
        'https://c.files.bbci.co.uk/6BEE/production/_125403672_gettyimages-1207828603.jpg',
        100000,
        450,
        '재고 1개 짜리 상품',
        8000,
        1,
        '2023-10-05 09:32:45.069682',
        '2023-09-05 09:32:45.069682',
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
values (88886,
        22222,
        222222,
        22222,
        2222,
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

--
--
-- -- 프로덕트 메모 productmemo
-- insert into productMemo(productmemo_id,
--                         product_id,
--                         content,
--                         created_At,
--                         updated_At)
-- values (11,
--         11,
--         '중요한 상품',
--         now(),
--         now());
--
-- insert into productMemo(productmemo_id,
--                         product_id,
--                         content,
--                         created_At,
--                         updated_At)
-- values (22,
--         11,
--         '안좋은 상품',
--         now(),
--         now());
--
-- insert into productMemo(productmemo_id,
--                         product_id,
--                         content,
--                         created_At,
--                         updated_At)
-- values (33,
--         22,
--         '인터 상품',
--         now(),
--         now());



--스톡 히스토리 stockhistory
insert into stockHistory(stockhistory_id,
                        product_id,
                        company_id,
                        content,
                        created_At,
                        updated_At)
values (11,
        88887,
        22222,
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
        99999,
        11111,
        '좋은 상품',
        now(),
        now());

-- 카트 아이템 cartsitem
-- insert into cartsitem(cartsitem_id,
--                       product_id,
--                       users_id,
--                       price,
--                       qty,
--                       created_At,
--                       updated_At)
-- values (22,
--         11,
--         22,
--         20000,
--         2,
--         now(),
--         now());

insert into cartsitem(cartsitem_id,
                      product_id,
                      users_id,
                      price,
                      qty,
                      created_At,
                      updated_At)
values (33,
        88888,
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
        88887,
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
        88886,
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
                       company_id,
                       shipped,
                       created_At,
                       updated_At)
values (22,
        99999,
        22,
        20000,
        2,
        11111,
        false,
        now(),
        now());


insert into ordersitem(ordersitem_id,
                       product_id,
                       users_id,
                       price,
                       qty,
                       company_id,
                       shipped,
                       created_At,
                       updated_At)
values (33,
        88888,
        22,
        300000,
        3,
        11111,
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
                     tracking_number,
                     shipped_at,
                     address_id,
                     created_At,
                     updated_At)
values (33,
        22,
        11111,
        300000,
        3000,
        297000,
        10,
        30,
        '우리집',
        '대한통운',
        'asdf234235asf',
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
        99999,
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
        99999,
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
values (34253,
        22,
        11111,
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
values (36745,
        22,
        11111,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (56768,
        22,
        11111,
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
values (789,
        22,
        11111,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (3353,
        22,
        11111,
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
values (1234232,
        22,
        11111,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (234546,
        22,
        11111,
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
values (86534,
        22,
        11111,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (664345,
        22,
        11111,
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
values (6573452,
        22,
        11111,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (8796425,
        22,
        11111,
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
values (3443667533,
        22,
        11111,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (3765366753,
        22,
        11111,
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
values (33667537653,
        22,
        22222,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (765347,
        22,
        22222,
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
values (2464245,
        22,
        22222,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (97875,
        22,
        22222,
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
values (654374,
        22,
        22222,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (87664567,
        22,
        22222,
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
values (3433456,
        22,
        22222,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
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
values (89064,
        22,
        22222,
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
values (4504527,
        22,
        22222,
        33,
        '입금',
        '주문 후 입금',
        0,
        30000,
        0,
        now(),
        now());

insert into productmemo(product_memo_id,
                        product_id,
                        created_At,
                        users_id,
                        updated_At,
                        content)
values (500,
        88888,
        now(),
        22,
        now(),
        '내용1');

insert into productmemo(product_memo_id,
                        product_id,
                        created_At,
                        users_id,
                        updated_At,
                        content)
values (501,
        88888,
        now(),
        22,
        now(),
        '내용');




