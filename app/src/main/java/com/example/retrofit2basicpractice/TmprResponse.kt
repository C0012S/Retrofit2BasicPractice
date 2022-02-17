package com.example.retrofit2basicpractice


import com.squareup.moshi.Json

data class TmprResponse(
    @field:Json(name = "TmprScrnIspcOfic")
    val tmprScrnIspcOfic: List<TmprScrnIspcOfic>?
)

data class TmprScrnIspcOfic(
    @field:Json(name = "head")
    val head: List<Head>?,
    @field:Json(name = "row")
    val row: List<Row>?
)

data class Head(
    @field:Json(name = "api_version")
    val apiVersion: String?,
    @field:Json(name = "list_total_count")
    val listTotalCount: Int?,
    @field:Json(name = "RESULT")
    val rESULT: RESULT?
)

data class RESULT(
    @field:Json(name = "CODE")
    val cODE: String?,
    @field:Json(name = "MESSAGE")
    val mESSAGE: String?
)

data class Row(
    @field:Json(name = "INSTL_LOC") // 설치위치
    val iNSTLLOC: String?,
    @field:Json(name = "OPR_LPERD") // 데이터기준일자
    val oPRLPERD: String?,
    @field:Json(name = "PUBLHELTH_NM") // 담당보건소명
    val pUBLHELTHNM: String?,
    @field:Json(name = "REFINE_LOTNO_ADDR") // 지번주소
    val rEFINELOTNOADDR: String?,
    @field:Json(name = "REFINE_ROADNM_ADDR") // 도로명주소
    val rEFINEROADNMADDR: String?,
    @field:Json(name = "SIGUN_NM") // 시군명
    val sIGUNNM: String?
)