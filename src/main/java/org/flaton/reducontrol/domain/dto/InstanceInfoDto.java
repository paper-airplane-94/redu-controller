package org.flaton.reducontrol.domain.dto;

import lombok.*;
import org.flaton.reducontrol.domain.entity.InstanceInfo;
import org.flaton.reducontrol.domain.vo.Redundancy;

import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class InstanceInfoDto {
    private String instanceId;
    private String appName;
    private String ipAddr;
    private String sid;
    private String hostName;
    private com.netflix.appinfo.InstanceInfo.InstanceStatus status;
    private Redundancy redundancy;
    private LocalDateTime lastUpdatedTimestamp;

    @Builder
    public InstanceInfoDto(String instanceId, String appName, String ipAddr,
                           String sid, String hostName, com.netflix.appinfo.InstanceInfo.InstanceStatus status,
                           Redundancy redundancy, LocalDateTime lastUpdatedTimestamp) {
        this.instanceId = instanceId;
        this.appName = appName;
        this.ipAddr = ipAddr;
        this.sid = sid;
        this.hostName = hostName;
        this.status = status;
        this.redundancy = redundancy;
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public static InstanceInfoDto of(InstanceInfo instanceInfo){
        return InstanceInfoDto.builder()
                .instanceId(instanceInfo.getInstanceId())
                .appName(instanceInfo.getAppName())
                .ipAddr(instanceInfo.getIpAddr())
                .sid(instanceInfo.getSid())
                .hostName(instanceInfo.getHostName())
                .status(instanceInfo.getStatus())
                .redundancy(instanceInfo.getRedundancy())
                .lastUpdatedTimestamp(instanceInfo.getLastUpdatedTimestamp())
                .build();
    }

    public InstanceInfo toEntity(){
        return InstanceInfo.builder()
                .instanceId(instanceId)
                .appName(appName)
                .ipAddr(ipAddr)
                .sid(sid)
                .hostName(hostName)
                .status(status)
                .redundancy(redundancy)
                .lastUpdatedTimestamp(lastUpdatedTimestamp)
                .build();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstanceInfoDto that = (InstanceInfoDto) o;
        return Objects.equals(instanceId, that.instanceId)
                && Objects.equals(appName, that.appName)
                && Objects.equals(ipAddr, that.ipAddr)
                && Objects.equals(sid, that.sid)
                && Objects.equals(hostName, that.hostName)
                && status == that.status
                && Objects.equals(lastUpdatedTimestamp, that.lastUpdatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceId, appName, ipAddr, sid, hostName, status, lastUpdatedTimestamp);
    }
}
