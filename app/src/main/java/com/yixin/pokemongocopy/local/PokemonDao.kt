package com.yixin.pokemongocopy.local

import androidx.paging.PagedList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yixin.pokemongocopy.entity.PokemonInfoEntity

@Dao
interface PokemonDao {
    // 批量插入数据到数据库中
    @Insert
    fun insertPokemonList(pokemonList: List<PokemonInfoEntity>)

    // 根据名称查询数据 :name表示函数中的参数
    @Query("SELECT * FROM pokemoninfoentity where name = :name")
    fun queryPokemonByName(name : String) : PokemonInfoEntity

    // 查询首页数据
    @Query("SELECT * FROM PokemonInfoEntity WHERE id >= :startId ORDER BY id LIMIT :limit")
    fun getPokemonList(startId: Int, limit: Int) : PagedList<PokemonInfoEntity>

    // 删除数据库中的数据

}