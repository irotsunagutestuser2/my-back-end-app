package com.example.sample.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * リポジトリクラスにてMongoDBからデータを送受信する用のピン情報を規定する型
 */
@Document
public record PinRecordEntity(
        @Id String id,
        String title,
        String description,
        double latitude,
        double longitude,
        String category,
        String imageUrl) {
}
