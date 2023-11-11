package com.kwiat.kwiaciarnia.Mappers;

import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Models.Flower;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlowerMapper implements RowMapper {

    private final ColourMapper colourMapper;


    public FlowerMapper(ColourMapper colourMapper){
        this.colourMapper = colourMapper;
    }

    public Flower mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flower flower = new Flower();
        flower.setID(rs.getInt("f_id"));
        flower.setName(rs.getString("f_name"));
        flower.setColour(colourMapper.mapRow(rs,rowNum));

        return flower;
    }
}
