package jjfactory.msa_study

import org.apache.catalina.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/users")
@RestController
class UserApi(
) {
    @GetMapping("/{id}")
    fun findUserById(@PathVariable id: Long): CommonResponse<UserResponse> {
        return CommonResponse(
            UserResponse(
                id = id,
                name = "lee"
            )
        )
    }

    data class UserResponse(
        val id: Long,
        val name: String
    )
}

