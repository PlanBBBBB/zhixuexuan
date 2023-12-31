package com.zhixue.media.api;

import com.zhixue.base.exception.XueChengPlusException;
import com.zhixue.base.model.PageParams;
import com.zhixue.base.model.PageResult;
import com.zhixue.base.model.RestResponse;
import com.zhixue.media.model.dto.QueryMediaParamsDto;
import com.zhixue.media.model.dto.UploadFileParamsDto;
import com.zhixue.media.model.dto.UploadFileResultDto;
import com.zhixue.media.model.po.MediaFiles;
import com.zhixue.media.service.MediaFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 媒资文件管理接口
 */
@Api(value = "媒资文件管理接口", tags = "媒资文件管理接口")
@RestController
public class MediaFilesController {
    @Autowired
    private MediaFileService mediaFileService;

    @ApiOperation("媒资列表查询接口")
    @PostMapping("/files")
    public PageResult<MediaFiles> list(PageParams pageParams, @RequestBody QueryMediaParamsDto queryMediaParamsDto) {
        Long companyId = 1232141425L;
        return mediaFileService.queryMediaFiles(companyId, pageParams, queryMediaParamsDto);
    }

    @ApiOperation("文件上传接口")
    @RequestMapping(value = "/upload/coursefile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadFileResultDto upload(@RequestPart("filedata") MultipartFile filedata,
                                      @RequestParam(value = "folder", required = false) String folder,
                                      @RequestParam(value = "objectName", required = false) String objectName) {
        Long companyId = 1232141425L;
        UploadFileParamsDto params = new UploadFileParamsDto();
        String contentType = filedata.getContentType();
        params.setContentType(contentType);
        params.setFileSize(filedata.getSize());
        assert contentType != null;
        if (contentType.contains("image")) {
            params.setFileType("001001");
        } else {
            params.setFileType("001003");
        }
        params.setFilename(filedata.getOriginalFilename());
        params.setRemark("");
        try {
            return mediaFileService.uploadFile(companyId, params, filedata.getBytes(), folder, objectName);
        } catch (IOException e) {
            throw new XueChengPlusException("文件上传过程中出错");
        }
    }

    @ApiOperation("预览文件")
    @GetMapping("/preview/{mediaId}")
    public RestResponse<String> getPlayUrlByMediaId(@PathVariable String mediaId) {
        MediaFiles mediaFiles = mediaFileService.getFileById(mediaId);
        return RestResponse.success(mediaFiles.getUrl());
    }

}
