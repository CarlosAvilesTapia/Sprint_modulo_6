package cl.cat2814.sprintmodulo6.model.repository

import cl.cat2814.sprintmodulo6.model.remoteData.Smartphone
import com.google.common.truth.Truth.assertThat

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {

        // Given
        val smartphoneTest = Smartphone(1, "Example phone", 100000, "Example image")

        // When
        val result = smartphoneTest.toEntity()

        // Then (usando Truth)
        assertThat(result.id).isEqualTo(1)
        assertThat(result.name).isEqualTo("Example phone")
        assertThat(result.price).isEqualTo(100000)
        assertThat(result.image).isEqualTo("Example image")
    }
}
