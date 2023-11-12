package com.kwiat.kwiaciarnia.Repository;

import com.kwiat.kwiaciarnia.Mappers.ColourMapper;
import com.kwiat.kwiaciarnia.Mappers.FlowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kwiat.kwiaciarnia.Models.Flower;
import com.kwiat.kwiaciarnia.Interfaces.FlowerInterface;

import java.util.List;

@Repository
public class FlowerRepository implements FlowerInterface
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int CreateFlower(Flower flower){
        return jdbcTemplate.update("INSERT INTO Flower (ColourID, Name) VALUES(?,?)",
                new Object[] { flower.getColour().getID(), flower.getName()});
    }

    @Override
    public int UpdateFlower(Flower flower){
        return jdbcTemplate.update("UPDATE Flower SET ColourID=?, Name=? WHERE id=?",
                new Object[] {flower.getColour().getID(), flower.getName(), flower.getID()});
    }

    @Override
    public List<Flower> GetAllFlowers() {
        List<Flower> res = jdbcTemplate.query(
                "SELECT f.ID f_id, f.Name f_name,c.ID c_id,c.ColourName c_colourName FROM Flower f INNER JOIN Colour c ON f.ColourID = c.ID",
                new FlowerMapper(new ColourMapper()));
        return res;
    }

    @Override
    public Flower GetFlowerByID(int id){
        var res = jdbcTemplate.queryForObject(
                "SELECT f.ID f_id, f.Name f_name,c.ID c_id,c.ColourName c_colourName FROM Flower f INNER JOIN Colour c ON f.ColourID = c.ID WHERE f.ID=?",
                new FlowerMapper(new ColourMapper()),id);
        return (Flower)res;
    }

    @Override
    public int DeleteFlower(int id){
        return jdbcTemplate.update("DELETE FROM Flower WHERE ID=?",id);
    }

}