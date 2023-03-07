package com.ev.BatteryStation.Controller;

import com.ev.BatteryStation.Model.StationModel;
import com.ev.BatteryStation.Service.StationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = StationController.class)
@WithMockUser
public class StationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StationService stationService;

    StationModel mockStation = new StationModel(1L, "EVStation", "Url:1235", 100.1,"India");

    String exampleStationJson = "[{\n" +
            "    \"id\": 1,\n" +
            "    \"name\": \"EVStation\",\n" +
            "    \"image\": \"Url:1235\",\n" +
            "    \"pricing\": 100.1,\n" +
            "    \"address\": \"India\"\n" +
            "}]";
    List<StationModel> stationModels = new ArrayList<>();


    @Test
    public void getAllStationsTest() throws Exception{
        Mockito.when(stationService.getAllStations()).thenReturn(List.of(mockStation));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"EVStation\",\n" +
                "    \"image\": \"Url:1235\",\n" +
                "    \"pricing\": 100.1,\n" +
                "    \"address\": \"India\"\n" +
                "}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}
