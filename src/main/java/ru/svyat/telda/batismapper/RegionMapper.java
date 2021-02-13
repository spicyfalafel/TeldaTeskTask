package ru.svyat.telda.batismapper;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import ru.svyat.telda.model.Region;


import java.util.List;

@Repository
@Mapper

public interface RegionMapper {

    @Select("select * from regions")
    List<Region> findAll();

    @Select("select * from regions where id = #{id}")
    Region getById(Integer id);

    @Insert("insert into regions(name, abbreviation) values (#{name}, #{abbreviation})")
    void insert(Region region);

    @Update("update regions set regions.name = #{region.name}, regions.abbreviation = #{region.abbreviation} where regions.id = #{id}")
    void update(Region region, Integer id);

    @Delete("delete from regions where id = #{id}")
    void deleteById(Integer id);

}
