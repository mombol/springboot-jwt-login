package com.mombol.common.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageParam<T> extends Page<T> {

    protected long size = 15;

}
