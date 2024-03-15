package com.example.sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sample.repository.entity.PinRecordEntity;

/**
 * バックエンドAPIのサンプルリポジトリ（MongoRepositoryをそのまま使用）
 */
public interface MongoAccessRepository extends MongoRepository<PinRecordEntity, String> {
}