package green.project.demo.plogging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PloggingModelDto {

	private String userId;

	private String ploggingTime;

	private String ploggingDistance;

	private String trashCount;

}
