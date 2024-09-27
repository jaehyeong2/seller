## 목표
msa를 찍먹해보면서 왜 트래픽이 많은 테크 기업들이 거의 필수로 kafka / redis를 사용하는지 학습해본다.


<br/>
- docker-compose.yml

postgres db 3대 / redis 1 / kafka 1 형태


```version: '3'
services:
  postgres_seller:
    image: postgres:15
    environment:
      POSTGRES_DB: seller_local
      POSTGRES_USER: seller_local
      POSTGRES_PASSWORD: seller_local
    ports:
      - "5432:5432"
    volumes:
      - postgres_seller_data:/var/lib/postgresql/data

  postgres_product:
    image: postgres:15
    environment:
      POSTGRES_DB: product_local
      POSTGRES_USER: product_local
      POSTGRES_PASSWORD: product_local
    ports:
      - "5433:5432"
    volumes:
      - postgres_product_data:/var/lib/postgresql/data

  postgres_order:
    image: postgres:15
    environment:
      POSTGRES_DB: order_local
      POSTGRES_USER: order_local
      POSTGRES_PASSWORD: order_local
    ports:
      - "5434:5432"
    volumes:
      - postgres_order_data:/var/lib/postgresql/data

  redis:
    image: redis:alpine
    command: redis-server --port 6379
    labels:
      - "name=redis"
      - "mode=standalone"
    ports:
      - 6379:6379

  zookeeper:
    container_name: zookeeper
    image: wurstmeister/zookeeper:latest
    ports:
      - "2181:2181"


  kafka:
    container_name: kafka
    image: wurstmeister/kafka:latest
    depends_on:
      - zookeeper
    ports:
      - "9094:9094"
    environment:
      # 카프카 접속 가능한 URL 설정
      KAFKA_ADVERTISED_LISTENERS: INSIDE://:9092,OUTSIDE://localhost:9094

      # 카프카 서버의 내부 리스너, 0.0.0.0으로 설정해야 카프카 서버 내부 인스턴스 통신 가능
      # 0.0.0.0은 카프카 서버의 모든 인터페이스에서 수신이 가능하다.
      KAFKA_LISTENERS: INSIDE://:9092,OUTSIDE://0.0.0.0:9094
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INSIDE:PLAINTEXT,OUTSIDE:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: INSIDE
      KAFKA_CREATE_TOPICS: "test:1:1"
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock

volumes:
  postgres_seller_data:
  postgres_product_data:
  postgres_order_data:

```

## Redis
다양한 자료구조를 지원하며, 싱글스레드로 동작하는 레디스는 캐싱 / 동시성 이슈 해결 / 디비 부하 분산 등 다양한 용도로 사용된다.

### Api rate limiter

### 중복 요청 제거


