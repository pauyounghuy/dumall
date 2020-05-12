package commons;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseMapper接口：使mapper包含完整的CRUD方法<br>
 * ConditionMapper接口：使mapper支持Condition类型参数<br>
 * MySqlMapper接口：使mapper支持MySQL特有的批量插入和返回自增字段<br>
 * IdsMapper接口：使mapper支持批量ID操作<br>
 *
 * @param <T> 实体类.class
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>,ConditionMapper<T>,IdsMapper<T> {
}
