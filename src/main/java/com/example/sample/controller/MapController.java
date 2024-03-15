package com.example.sample.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.sample.model.PinRecordModel;
import com.example.sample.repository.entity.PinRecordEntity;
import com.example.sample.service.MapService;

/**
 * バックエンドAPIのサンプルコントローラ
 */
@RestController
public class MapController {

	/**
	 * サービス層のクラスを定義
	 */
	private final MapService service;

	/**
	 * コンストラクタ
	 * 
	 * @param service
	 */
	public MapController(MapService service) {
		this.service = service;
	}

	// /**
	// * 疎通確認用
	// *
	// * @return 指定したidのデータ
	// */
	// @GetMapping("/test")
	// public String getTest() {
	// return "APServer OK!";
	// }

	/**
	 * 全格納データを返却する
	 * 
	 * @return 全格納データ
	 */
	@GetMapping
	public List<PinRecordEntity> getAll() {
		return service.findAll();
	}

	/**
	 * 指定したidのデータを返却する
	 * 
	 * @param id
	 * @return 指定したidのデータ
	 */
	@GetMapping("/{id}")
	public PinRecordEntity getById(@PathVariable String id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
	}

	/**
	 * 指定したJsonデータを格納する
	 * 
	 * @param pinRecord
	 * @return 格納したデータ
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PinRecordEntity create(@RequestBody @Validated PinRecordModel pinRecord) {
		return service.create(pinRecord);
	}

	/**
	 * 指定したidのデータを指定したJsonデータで上書きする
	 * 
	 * @param id
	 * @param pinRecord
	 * @return 上書きしたデータ
	 */
	@PostMapping("/{id}")
	public PinRecordEntity update(@PathVariable String id, @RequestBody @Validated PinRecordModel pinRecord) {
		// IDの存在チェック
		boolean exists = service.existsById(id);
		if (!exists) {
			// IDが存在しない場合はエラーを返す
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found with ID: " + id);
		}

		return service.update(id, pinRecord);
	}

	/**
	 * 指定したidのデータを削除する
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}
}