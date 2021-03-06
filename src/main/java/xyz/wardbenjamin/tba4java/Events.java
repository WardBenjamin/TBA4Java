package xyz.wardbenjamin.tba4java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import xyz.wardbenjamin.tba4java.models.Award;
import xyz.wardbenjamin.tba4java.models.Event;
import xyz.wardbenjamin.tba4java.models.Match;
import xyz.wardbenjamin.tba4java.models.Team;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class Events {
    public static Event getEvent(String eventKey)
    {
        Event eventToReturn = new Event();
        try
        {
            Gson gson = new GsonBuilder().create();
            String url = (Constants.TBA_API_URL + "event/" + eventKey);
            eventToReturn = gson.fromJson(DataRequest.getDataFromTBA(url), Event.class);
        }
        catch (Exception e) { e.printStackTrace(); }
        return eventToReturn;
    }

    public static Award[] getEventAwards(String eventKey)
    {
        ArrayList<Award> dataList = new ArrayList<>();
        try
        {
            Gson gson = new GsonBuilder().create();
            String url = (Constants.TBA_API_URL + "event/" + eventKey + "/awards");
            Type listType = new TypeToken<ArrayList<Award>>() {}.getType();
            dataList = gson.fromJson(DataRequest.getDataFromTBA(url), listType);
        }
        catch (Exception e)  { e.printStackTrace(); }
        return Arrays.copyOf(dataList.toArray(), dataList.toArray().length, Award[].class);
    }

    public static Match[] getEventMatches(String eventKey)
    {
        ArrayList<Match> dataList = new ArrayList<>();
        try
        {
            Gson gson = new GsonBuilder().create();
            String url = (Constants.TBA_API_URL + "event/" + eventKey + "/matches");
            Type listType = new TypeToken<ArrayList<Match>>() {}.getType();
            dataList = gson.fromJson(DataRequest.getDataFromTBA(url), listType);
        }
        catch (Exception e)  { e.printStackTrace(); }
        return Arrays.copyOf(dataList.toArray(), dataList.toArray().length, Match[].class);
    }

    public static Team[] getEventTeamsList(String eventKey)
    {
        ArrayList<Team> teamList = new ArrayList<>();
        try
        {
            Gson gson = new GsonBuilder().create();
            String url = (Constants.TBA_API_URL + "event/" + eventKey + "/teams");
            Type listType = new TypeToken<ArrayList<Team>>() {}.getType();
            teamList = gson.fromJson(DataRequest.getDataFromTBA(url), listType);
        }
        catch (Exception e)  { e.printStackTrace(); }
        return Arrays.copyOf(teamList.toArray(), teamList.toArray().length, Team[].class);
    }

    public static Event[] getEvents(int year)
    {
        ArrayList<Event> dataList = new ArrayList<>();
        try
        {
            Gson gson = new GsonBuilder().create();
            String url = (Constants.TBA_API_URL + "events/" + year);
            Type listType = new TypeToken<ArrayList<Event>>() {}.getType();
            dataList = gson.fromJson(DataRequest.getDataFromTBA(url), listType);
        }
        catch (Exception e)  { e.printStackTrace(); }
        return Arrays.copyOf(dataList.toArray(), dataList.toArray().length, Event[].class);
    }
}
