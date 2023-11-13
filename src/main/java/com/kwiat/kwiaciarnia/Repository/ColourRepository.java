package com.kwiat.kwiaciarnia.Repository;

import com.kwiat.kwiaciarnia.Interfaces.ColourInterface;
import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColourRepository implements ColourInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int CreateColour(String colourName){
        return jdbcTemplate.update("INSERT INTO Colour (ColourName) VALUES(?)", colourName);
    }

    @Override
    public int UpdateColour(Colour colour){
        return jdbcTemplate.update("UPDATE Colour SET ColourName=? WHERE ID=?",
                new Object[] {colour.getColourName(), colour.getID()});
    }

    @Override
    public List<Colour> GetAllColours() {
        return jdbcTemplate.query("SELECT * FROM Colour", BeanPropertyRowMapper.newInstance(Colour.class));
    }

    @Override
    public Colour GetColourByID(int id){
        String sql = "SELECT * FROM Colour WHERE ID=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Colour.class), id);
    }

    @Override
    public int DeleteColour(int id){
        return jdbcTemplate.update("DELETE FROM Colour WHERE ID=?",id);
    }
}
