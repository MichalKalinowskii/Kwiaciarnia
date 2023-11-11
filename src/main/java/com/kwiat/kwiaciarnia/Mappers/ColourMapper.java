package com.kwiat.kwiaciarnia.Mappers;

import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Models.Flower;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColourMapper implements RowMapper {
    public Colour mapRow(ResultSet rs, int rowNum) throws SQLException {
        Colour colour = new Colour();
        colour.setID(rs.getInt("c_id"));
        colour.setColourName(rs.getString("c_colourName"));
        return colour;
    }
}
