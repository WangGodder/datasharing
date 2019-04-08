package top.godder.infrastructurecommon.database;
/**
 * -------------------------------------------------
 *
 * @ Author  :       pengj
 * @ date    :       2018/12/18 15:53
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


// 继承的这2个里面就包含了crud、以及分页、条件查询的所有组件了
public interface BaseMapper<T> extends
        // TODO: 2018/12/18
        Mapper<T>,//Mapper<T> extends BaseMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>, Marker
        MySqlMapper<T>,// MySqlMapper<T> extends InsertListMapper<T>, InsertUseGeneratedKeysMapper<T>
//        IdsMapper<T>,//IdsMapper<T> extends SelectByIdsMapper<T>, DeleteByIdsMapper<T>
        ConditionMapper<T>//ConditionMapper<T> extends SelectByConditionMapper<T>, SelectCountByConditionMapper<T>, DeleteByConditionMapper<T>, UpdateByConditionMapper<T>, UpdateByConditionSelectiveMapper<T>
{
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}

