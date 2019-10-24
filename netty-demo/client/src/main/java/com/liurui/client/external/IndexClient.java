package com.liurui.client.external;

import com.liurui.IndexApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author liu-rui
 * @date 2019/10/23 上午11:41
 * @description
 * @since
 */
@FeignClient(value = "index" , url = "${api.index.url}")
public interface IndexClient extends IndexApi {
}
