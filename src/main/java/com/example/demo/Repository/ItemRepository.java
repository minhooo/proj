package com.example.demo.Repository;


import com.example.demo.entity.Board;
import com.example.demo.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// DB 처리에 대한 Annotation(Component)
@Repository
public class ItemRepository {
    static final Logger log = LoggerFactory.getLogger(BoardRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Item item) throws Exception {
        String query =  "insert into record_table(Id, Pw, NickName, Item, Price) values(?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, item.getId(),
                item.getPw(), item.getNickName(), item.getItem(), item.getPrice());
    }

    public List<Item> list() throws Exception {
        log.info("Repository list()");

        List<Item> results = jdbcTemplate.query(
                "select Id, Pw, NickName,Item, Price " +
                        "from record_table " +
                        "where Id> 0 order by " +
                        "Id desc",
                new RowMapper<Item>(){
                    @Override
                    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Item item = new Item();
                        item.setId(rs.getInt("Id"));
                        item.setPw(rs.getString("Pw"));
                        item.setNickName(rs.getString("NickName"));
                        item.setItem(rs.getInt("Item"));
                        item.setPrice(rs.getInt("Price"));
                        return item;
                    }
                });
        return results;
    }

    public Item read(Integer Id) throws Exception{

        List<Item> results = jdbcTemplate.query(
                "select Id, Pw, NickName, Item, Price, " +
                        " from board where Id = ?",
                new RowMapper<Item>() {
                    @Override
                    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Item item = new Item();

                        item.setId(rs.getInt("Id"));
                        item.setPw(rs.getString("Pw"));
                        item.setNickName(rs.getString("NickName"));
                        item.setItem(rs.getInt("Item"));
                        item.setPrice(rs.getInt("Price"));
                        return item;
                    }
                }, Id
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public void remove(Integer Id) throws Exception{

        String query = "delete from record_table where id = ?";
        jdbcTemplate.update(query, Id);
    }

    public void modify(Item item) throws Exception{

        String query = "update record_table set Pw = ?, Price = ? " +
                "where Id =?";
        jdbcTemplate.update(
                query, item.getPw(),
                item.getPrice(), item.getItem()
        );
    }
}
