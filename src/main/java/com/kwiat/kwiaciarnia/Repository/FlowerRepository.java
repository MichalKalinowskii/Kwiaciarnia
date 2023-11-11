package com.kwiat.kwiaciarnia.Repository;

import com.kwiat.kwiaciarnia.Mappers.ColourMapper;
import com.kwiat.kwiaciarnia.Mappers.FlowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kwiat.kwiaciarnia.Models.Flower;
import com.kwiat.kwiaciarnia.Interfaces.FlowerInterface;

import java.util.List;

@Repository
public class FlowerRepository implements FlowerInterface
{
    @Autowired
    JdbcTemplate _jdbcTemplate;

    @Override
    public List<Flower> GetAllFlowers() {
        List<Flower> res = _jdbcTemplate.query(
                "select f.ID f_id, f.Name f_name,c.ID c_id,c.ColourName c_colourName from Flower as f inner join Colour as c on f.ColourID = c.ID",
                new FlowerMapper(new ColourMapper()));
        return res;
    }

    @Override
    public List<Flower> GetFlowersByName(String name){
        String sql = "SELECT f.ID f_id, f.Name f_name,c.ID c_id,c.ColourName c_colourName FROM Flower f inner join Colour c on f.ColourID = c.ID WHERE Name LIKE '%" +name +"%'";
        return _jdbcTemplate.query(sql, new FlowerMapper(new ColourMapper()));
    }
}