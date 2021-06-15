<template>
  <div>
    <h3>지도</h3>
    <div id="map"></div>
    <p>
      <button @click="setOverlayMapTypeId('')">일반지도 보기</button>
      <button @click="setOverlayMapTypeId('traffic')">교통정보 보기</button>
      <button @click="setOverlayMapTypeId('roadview')">로드뷰 도로정보 보기</button>
      <button @click="setOverlayMapTypeId('terrain')">지형정보 보기</button>
      <button @click="setOverlayMapTypeId('use_district')">지적편집도 보기</button>
    </p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  props: {
    pitems: [],
  },
  data() {
    return {
      map: Object,
      currentTypeId: Object,
      marker: Object,
      markers: [],

      positions: [
        {
          title: '카카오',
          latlng: new kakao.maps.LatLng(37.56536, 126.947615),
        },
        {
          title: '생태연못',
          latlng: new kakao.maps.LatLng(37.56433, 126.947615),
        },
        {
          title: '텃밭',
          latlng: new kakao.maps.LatLng(37.56435, 126.947615),
        },
        {
          title: '근린공원',
          latlng: new kakao.maps.LatLng(37.564343, 126.947615),
        },
      ],
    };
  },
  methods: {
    // 지도2
    initMap() {
      var mapContainer = document.getElementById('map'); // 지도를 표시할 div
      var mapOption = {
        title: 'SSAFY!',
        center: new kakao.maps.LatLng(37.50145998861512, 127.03963824042815), // 지도의 중심좌표
        level: 4, // 지도의 확대 레벨
      };

      // 지도 생성
      this.map = new kakao.maps.Map(mapContainer, mapOption);

      // 1. 우 상단 컨트롤러
      this.controller_tr(this.map);

      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
      // 마커 이미지의 이미지 크기 입니다
      var imageSize = new kakao.maps.Size(24, 35);
      // 마커 이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

      this.marker = new kakao.maps.Marker({
        map: this.map, // 마커를 표시할 지도
        position: new kakao.maps.LatLng(37.50145998861512, 127.03963824042815), // 마커를 표시할 위치
        title: 'SSAFY', // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image: markerImage, // 마커 이미지
      });
      this.marker.setMap(this.map);
      this.markers.push(this.marker);
      // }
    },
    // 1.우상단 컨트롤러.
    controller_tr(map) {
      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // 그리고 kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
    },
    // 2. 지도 타입 변경.
    setOverlayMapTypeId(maptype) {
      var changeMaptype;

      // maptype에 따라 지도에 추가할 지도타입을 결정합니다
      if (maptype === 'traffic') {
        // 교통정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.TRAFFIC;
      } else if (maptype === 'roadview') {
        // 로드뷰 도로정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.ROADVIEW;
      } else if (maptype === 'terrain') {
        // 지형정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.TERRAIN;
      } else if (maptype === 'use_district') {
        // 지적편집도 지도타입
        changeMaptype = kakao.maps.MapTypeId.USE_DISTRICT;
      } else if (maptype === '') {
        // 일반 지도 지도타입
        changeMaptype = kakao.maps.MapTypeId.ROADMAP;
      }

      // 이미 등록된 지도 타입이 있으면 제거합니다
      if (this.currentTypeId) {
        this.map.removeOverlayMapTypeId(this.currentTypeId);
      }

      // maptype에 해당하는 지도타입을 지도에 추가합니다
      this.map.addOverlayMapTypeId(changeMaptype);

      // 지도에 추가된 타입정보를 갱신합니다
      this.currentTypeId = changeMaptype;
    },
  },
  // 지도 초기화
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b8b4b7fe81b57bc5fe56f4b0aaf3c4d4&libraries=services,clusterer,drawing';
      document.head.appendChild(script);
    }
  },
  watch: {
    esInfos: function () {
      for (let i = 1; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      // 마커 이미지의 이미지 주소입니다
      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';

      for (var i = 0; i < this.esInfos.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);
        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var pos = {
          center: new kakao.maps.LatLng(this.esInfos[i].lat * 1, this.esInfos[i].lng * 1),
          title: this.esInfos[i].aptName,
        };
        // 마커를 생성합니다
        this.marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: pos.center, // 마커를 표시할 위치
          title: pos.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });
        this.marker.setMap(this.map);
        this.markers.push(this.marker);
      }
      this.map.panTo(pos.center);

      // return this.map;
    },
  },
  computed: {
    ...mapGetters(['user', 'esInfos']),
  },
};
</script>

<style>
#map {
  height: 35vmax;
}
</style>
