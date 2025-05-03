package havryliuk.sequrity2025.gameservice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
  @author   umaks
  @project   gameservice-security2025
  @class  AccessTest
  @version 1.0.0
  @since 03.05.2025 - 1:00
*/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTest {

    @Autowired
    private  WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeAll() {
        this.mockMvc= MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithAnonymousUser
    public void whenAnonymousThenStatusUnauthorised() throws Exception{
        mockMvc.perform(get("/api/v1/games"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStausOk() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedWithUncorrecctUserThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/user"))
                .andExpect(status().isForbidden());
    }



    @Test
    @WithMockUser(roles = {"USER"})
    void userForbiddenAdminHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/admin"))
                .andExpect(status().isForbidden());
    }


    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedAdminHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/admin"))
                .andExpect(status().isUnauthorized());
    }

    // #4
    @Test
    @WithMockUser(roles = {"ADMIN"})
    void test04_adminForbiddenUserHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void userAccessUserHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/user"))
                .andExpect(status().isOk());
    }


    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedUserHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/user"))
                .andExpect(status().isUnauthorized());
    }

    // #7
    @Test
    @WithMockUser(roles = {"ADMIN"})
    void test07_adminAccessUnknownHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/unknown"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    void userAccessUnknownHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/unknown"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedUnknownHello() throws Exception {
        mockMvc.perform(get("/api/v1/games/hello/unknown"))
                .andExpect(status().isUnauthorized());
    }


    @Test
    @WithMockUser(roles = {"ADMIN"})
    void adminAccessIndexHtml() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(roles = {"USER"})
    void userAccessIndexHtml() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk());
    }


    @Test
    @WithAnonymousUser
    void anonymousAccessIndexHtml() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk());
    }
    
    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedGetAllGames() throws Exception {
        mockMvc.perform(get("/api/v1/games/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedGetOneGame() throws Exception {
        mockMvc.perform(get("/api/v1/games/1"))
                .andExpect(status().isUnauthorized());
    }




    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedDeleteGame() throws Exception {
        mockMvc.perform(delete("/api/v1/games/1"))
                .andExpect(status().isUnauthorized());
    }





    @Test
    @WithMockUser(roles = {"USER"})
    void userForbiddenCreateGame() throws Exception {
        mockMvc.perform(post("/api/v1/games/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"TLOU\", \"description\": \"The Last Of Us\", \"sells\": 1000000}"))
                .andExpect(status().isForbidden());
    }


    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedCreateGame() throws Exception {
        mockMvc.perform(post("/api/v1/games/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"TLOU\", \"description\": \"The Last Of Us\", \"sells\": 1000000}"))
                .andExpect(status().isUnauthorized());
    }



    @Test
    @WithAnonymousUser
    void anonymousUnauthorizedUpdateGame() throws Exception {
        mockMvc.perform(put("/api/v1/games/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"2\", \"name\": \"GOW\", \"description\": \"God Of War\", \"sells\": 2000000}"))
                .andExpect(status().isUnauthorized());
    }
}
