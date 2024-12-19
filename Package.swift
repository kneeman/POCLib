// swift-tools-version:5.7
import PackageDescription

let package = Package(
    name: "POCLib",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "POCLib",
            targets: ["POCLib"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "POCLib",
            path: "./POCLib.xcframework"
        )
    ]
)

// // swift-tools-version:5.3
// import PackageDescription
//
// let package = Package(
//    name: "POCLib",
//    platforms: [
//      .iOS(.v14),
//    ],
//    products: [
//       .library(name: "POCLib", targets: ["POCLib"])
//    ],
//    targets: [
//       .binaryTarget(
//          name: "POCLib",
//          url: "<link to the uploaded XCFramework ZIP file>",
//          checksum:"<checksum calculated for the ZIP file>")
//    ]
// )