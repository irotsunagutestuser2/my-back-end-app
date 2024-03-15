package com.example.sample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.sample.model.PinRecordModel;
import com.example.sample.repository.MongoAccessRepository;
import com.example.sample.repository.entity.PinRecordEntity;

/**
 * バックエンドAPIのサンプルサービス
 */
@Service
public class MapService {

    /**
     * リポジトリ層のクラス定義
     */
    private final MongoAccessRepository repository;

    /**
     * コンストラクタ
     * 
     * @param repository
     */
    public MapService(MongoAccessRepository repository) {
        this.repository = repository;
    }

    /**
     * 全格納データを参照する
     * 
     * @return
     */
    public List<PinRecordEntity> findAll() {
        return repository.findAll();
    }

    /**
     * 指定したidのデータを参照する
     * 
     * @param id
     * @return 指定したidのデータ
     */
    public Optional<PinRecordEntity> findById(String id) {
        return repository.findById(id);
    }

    /**
     * 指定したidのデータが存在するか確認する
     * 
     * @param id
     * @return 存在確認結果
     */
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    /**
     * 指定したデータを登録する
     * 
     * @param PinRecordModel
     * @return 格納したデータ
     */
    public PinRecordEntity create(PinRecordModel pinRecord) {
        // 新しいPinRecordインスタンスを作成して保存(UUIDをIDとして生成して登録)
        PinRecordEntity newPinRecord = new PinRecordEntity(UUID.randomUUID()
                .toString(), pinRecord.title(), pinRecord.description(),
                pinRecord.latitude(),
                pinRecord.longitude(), pinRecord.category(), pinRecord.imageUrl());
        return repository.save(newPinRecord);
    }

    /**
     * 指定したデータを更新する
     * 
     * @param PinRecordModel
     * @return 格納したデータ
     */
    public PinRecordEntity update(String id, PinRecordModel pinRecord) {
        // 新しいPinRecordインスタンスを作成して保存
        PinRecordEntity newPinRecord = new PinRecordEntity(id, pinRecord.title(), pinRecord.description(),
                pinRecord.latitude(),
                pinRecord.longitude(), pinRecord.category(), pinRecord.imageUrl());
        return repository.save(newPinRecord);
    }

    /**
     * 指定したidのデータを削除する
     * 
     * @param id
     */
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
