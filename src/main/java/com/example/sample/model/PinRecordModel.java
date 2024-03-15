package com.example.sample.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

/**
 * コントローラクラスでのデータ受付用にピンの情報を規定する型
 * 必須チェック(@NotNull)を行っているため、各項目の値はすべて含まれている必要がある
 */
@Document
public record PinRecordModel(
                // タイトル
                @NotNull(message = "title is required") String title,
                // 説明
                @NotNull(message = "description is required") String description,
                // 緯度
                @NotNull(message = "latitude is required") double latitude,
                // 経度
                @NotNull(message = "longitude is required") double longitude,
                // カテゴリ
                @NotNull(message = "category is required") String category,
                // イメージURL
                @NotNull(message = "imageUrl is required") String imageUrl) {
}
